package com.example.Produtos.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.Produtos.R
import com.example.Produtos.dao.ProdutoDao
import com.example.Produtos.ui.components.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutos : AppCompatActivity(R.layout.activity_lista_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        configRecycleView()
        configBotaoSalvar()
    }

    fun configRecycleView(){
        val listaTarefaView = findViewById<RecyclerView>(R.id.lista_tarefas)
        listaTarefaView.adapter = ListaProdutosAdapter(ProdutoDao().buscarTarefa(), this)
    }
    fun configBotaoSalvar(){
        val btnAdd = findViewById<FloatingActionButton>(R.id.btn_add_tarefa)
        btnAdd.setOnClickListener {
            val intent = Intent(this, FormularioProdutos::class.java)
            startActivity(intent)
        }
    }
}