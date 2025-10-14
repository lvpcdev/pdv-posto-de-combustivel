package com.br.pdvpostocombustivel.api.acesso;


import com.br.pdvpostocombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostocombustivel.api.acesso.dto.AcessoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/acessos")
public class AcessoController {
    private final AcessoService service;

    public AcessoController(AcessoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcessoResponse create(@RequestBody AcessoRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public AcessoResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping(params = "usuario")
    public AcessoResponse getByUsuario(@RequestParam String usuario) {
        return service.getByUsuario(usuario);
    }

    @GetMapping
    public Page<AcessoResponse> list(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sortBy,
                                     @RequestParam(defaultValue = "ASC") Sort.Direction dir) {
        return service.list(page, size, sortBy, dir);
    }

    @PutMapping("/{id}")
    public AcessoResponse update(@PathVariable Long id, @RequestBody AcessoRequest req) {
        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public AcessoResponse patch(@PathVariable Long id, @RequestBody AcessoRequest req) {
        return service.patch(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
