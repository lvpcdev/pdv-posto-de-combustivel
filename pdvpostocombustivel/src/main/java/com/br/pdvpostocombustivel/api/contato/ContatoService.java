package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.repository.ContatoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ContatoService {
    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public ContatoResponse create(ContatoRequest req) {
        Contato novoContato = toEntity(req);
        return toResponse(repository.save(novoContato));
    }

    // READ by ID - validar a utilização desse método
    @Transactional(readOnly = true)
    public ContatoResponse getById(Long id) {
        Contato p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));
        return toResponse(p);
    }

    // READ by Email
    @Transactional(readOnly = true)
    public ContatoResponse getByEmail(String email) {
        Contato p = repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. email=" + email));
        return toResponse(p);
    }

    // LIST paginado
    @Transactional(readOnly = true)
    public Page<ContatoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    // UPDATE  - substitui todos os campos
    public ContatoResponse update(Long id, ContatoRequest req) {
        Contato p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));

        if (req.email() != null && !req.email().equals(p.getEmail())) {
            validarUnicidadeEmail(req.email(), id);
        }

        p.setTelefone(req.telefone());
        p.setEmail(req.email());
        p.setEndereco(req.endereco());

        return toResponse(repository.save(p));
    }

    // PATCH - atualiza apenas campos não nulos
    public ContatoResponse patch(Long id, ContatoRequest req) {
        Contato p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));

        if (req.endereco() != null)  p.setEndereco(req.endereco());
        if (req.email() != null) {
            if (!req.email().equals(p.getEmail())) {
                validarUnicidadeEmail(req.email(), id);
            }
            p.setEmail(req.email());
        }

        return toResponse(repository.save(p));
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Contato não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    // ---------- Helpers ----------
    private void validarUnicidadeEmail(String email, Long idAtual) {
        repository.findByEmail(email).ifPresent(existente -> {
            if (idAtual == null || !existente.getId().equals(idAtual)) {
                throw new DataIntegrityViolationException("Email já cadastrado: " + email);
            }
        });
    }

    private Contato toEntity(ContatoRequest req) {
        return new Contato(
                req.telefone(),
                req.email(),
                req.endereco(),
                req.tipoContato()
        );
    }

    private ContatoResponse toResponse(Contato p) {
        return new ContatoResponse(
                p.getId(),
                p.getTelefone(),
                p.getEmail(),
                p.getEndereco(),
                p.getTipoContato()
        );
    }
}
