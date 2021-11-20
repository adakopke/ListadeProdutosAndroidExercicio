package com.example.Produtos.ui.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Produtos.R
import com.example.Produtos.models.Produto

class ListaProdutosAdapter(
    private val produtos: List<Produto>,
    private val context: Context
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun vincular(tarefas: Produto){
            val itemTitulo = itemView.findViewById<TextView>(R.id.item)
            itemTitulo.text = tarefas.titulo

            val descricao = itemView.findViewById<TextView>(R.id.item_descricao)
            descricao.text = tarefas.descricao

            val valor = itemView.findViewById<TextView>(R.id.item_valor)
            valor.text = tarefas.valor.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefas =  produtos[position]
        holder.vincular(tarefas)
    }

    override fun getItemCount(): Int = produtos.size
}