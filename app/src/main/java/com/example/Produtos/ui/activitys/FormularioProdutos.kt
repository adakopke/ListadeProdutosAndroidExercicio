package com.example.Produtos.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.Produtos.R
import com.example.Produtos.dao.ProdutoDao
import com.example.Produtos.models.Produto

class FormularioProdutos : AppCompatActivity(R.layout.activity_formulario_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        confiBotaoSalvar()

    }

    fun confiBotaoSalvar(){
        val btnSalvar = findViewById<Button>(R.id.form_btn_salvar)
        btnSalvar.setOnClickListener {
            salvarTarefa()
        }
    }

    fun salvarTarefa(){
        val textTitulo = findViewById<EditText>(R.id.form_titulo)
        val textDescricao = findViewById<EditText>(R.id.form_descricao)
        val textValor = findViewById<EditText>(R.id.form_valor)
        val titulo = textTitulo.text.toString()
        val descricao = textDescricao.text.toString()
        val valor = textValor.text.toString()

        val novaTarefa =  Produto(titulo, descricao, valor)
        ProdutoDao().salvar(novaTarefa)
        Log.i("FormularioTarefa", "titulo: $titulo")
        Log.i("FormularioTarefa", "descricao: $descricao")
        Log.i("FormularioTarefa", "valor: $valor")
        Log.i("FormularioTarefa", "tarefa $novaTarefa")

        AlertDialog.Builder(this)
            .setTitle("Adicionado com sucesso")
            .setMessage("Produto $titulo adicionado com sucesso")
            .setPositiveButton("Ok"){_,_ ->  finish() }
            .show()

    }
}