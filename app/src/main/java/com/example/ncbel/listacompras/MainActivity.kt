package com.example.ncbel.listacompras

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.valor_total)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_itens)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transacoes = listOf(Transacao(BigDecimal("200.0"),categoria = "carnes"),
                Transacao(BigDecimal("100.0") ,categoria = "Legumes"))

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
