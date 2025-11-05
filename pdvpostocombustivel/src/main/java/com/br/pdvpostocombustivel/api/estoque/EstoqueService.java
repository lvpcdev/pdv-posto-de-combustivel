package com.br.pdvpostocombustivel.api.estoque;

import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueResponse;
import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.repository.EstoqueRepository;
import com.br.pdvpostocombustivel.enums.TipoEstoque;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class EstoqueService {

    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public EstoqueResponse create(EstoqueRequest req) {
        validarUnicidadeLoteFabricacao(req.localFabricacao(), null);
        Estoque novoEstoque = toEntity(req);
        return toResponse(repository.save(novoEstoque));
    }

    // READ by ID
    @Transactional(readOnly = true)
    public EstoqueResponse getById(Long id) {
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id=" + id));
        return toResponse(e);
    }

    // READ by Lote de Fabricação
    @Transactional(readOnly = true)
    public EstoqueResponse getByLoteFabricacao(String loteFabricacao) {
        Estoque e = repository.findByLoteFabricacao(loteFabricacao)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. loteFabricacao=" + loteFabricacao));
        return toResponse(e);
    }

    // LIST paginado
    @Transactional(readOnly = true)
    public Page<EstoqueResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    // UPDATE - substitui todos os campos
    public EstoqueResponse update(Long id, EstoqueRequest req) {
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id=" + id));

        if (req.localFabricacao() != null && !req.localFabricacao().equals(e.getLoteFabricacao())) {
            validarUnicidadeLoteFabricacao(req.localFabricacao(), id);
        }

        e.setQuantidade(req.quantidade());
        e.setLocalTanque(req.localTanque());
        e.setLocalEndereco(req.localEndereco());
        e.setLoteFabricacao(req.localFabricacao());
        e.setDataValidade(req.dataValidade());
        e.setTipoEstoque(req.tipoEstoque());

        return toResponse(repository.save(e));
    }

    // PATCH - atualiza apenas campos não nulos
    public EstoqueResponse patch(Long id, EstoqueRequest req) {
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id=" + id));

        if (req.quantidade() != null) e.setQuantidade(req.quantidade());
        if (req.localTanque() != null) e.setLocalTanque(req.localTanque());
        if (req.localEndereco() != null) e.setLocalEndereco(req.localEndereco());
        if (req.localFabricacao() != null) {
            if (!req.localFabricacao().equals(e.getLoteFabricacao())) {
                validarUnicidadeLoteFabricacao(req.localFabricacao(), id);
            }
            e.setLoteFabricacao(req.localFabricacao());
        }
        if (req.dataValidade() != null) e.setDataValidade(req.dataValidade());
        if (req.tipoEstoque() != null) e.setTipoEstoque(req.tipoEstoque());

        return toResponse(repository.save(e));
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Estoque não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    // ---------- Helpers ----------
    private void validarUnicidadeLoteFabricacao(String loteFabricacao, Long idAtual) {
        repository.findByLoteFabricacao(loteFabricacao).ifPresent(existente -> {
            if (idAtual == null || !existente.getId().equals(idAtual)) {
                throw new DataIntegrityViolationException("Lote de Fabricação já cadastrado: " + loteFabricacao);
            }
        });
    }

    private Estoque toEntity(EstoqueRequest req) {
        Estoque e = new Estoque();
        e.setQuantidade(req.quantidade());
        e.setLocalTanque(req.localTanque());
        e.setLocalEndereco(req.localEndereco());
        e.setLoteFabricacao(req.localFabricacao());
        e.setDataValidade(req.dataValidade());
        e.setTipoEstoque(req.tipoEstoque());
        return e;
    }

    private EstoqueResponse toResponse(Estoque e) {
        return new EstoqueResponse(
                e.getId(),
                e.getQuantidade(),
                e.getLocalTanque(),
                e.getLocalEndereco(),
                e.getLoteFabricacao(),
                e.getDataValidade(),
                e.getTipoEstoque()
        );
    }
}
