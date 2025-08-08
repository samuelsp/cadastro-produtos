package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaCollectionRepositoryTest {
    @Test
    void findByIdShouldReturnCategoriaWhenExists() {
        Categoria categoria = CategoriaCollectionRepository.findById(1L);
        assertNotNull(categoria);
        assertEquals(1L, categoria.getId());
    }

    @Test
    void findByIdShouldReturnNullWhenNotExists() {
        Categoria categoria = CategoriaCollectionRepository.findById(999L);
        assertNull(categoria);
    }

    @Test
    void saveShouldAddNewCategoriaAndAssignId() {
        Categoria newCategoria = new Categoria("Tecnologia");
        Categoria saved = CategoriaCollectionRepository.save(newCategoria);

        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertTrue(CategoriaCollectionRepository.findAll().contains(saved));
    }
}