package com.example.ncbel.listacompras

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transacoes = listOf(Transacao(BigDecimal("200.0"),categoria = "carnes"),
                Transacao(BigDecimal("100.0") ,categoria = "Legumes"))

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)


    }
}
