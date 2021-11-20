package com.example.Produtos.dao

import com.example.Produtos.models.Produto

class ProdutoDao {

    fun salvar(produto: Produto){
        tarefas.add(produto)
    }

    fun buscarTarefa() : List<Produto>{
        return tarefas.toList()
    }

    companion object {
        private val tarefas =  mutableListOf<Produto>()
    }
}