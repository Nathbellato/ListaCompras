package com.example.ncbel.listacompras

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.ncbel.listacompras.Fragment.ListaFragment
import com.example.ncbel.listacompras.R.*
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            id.nav_lista -> {
                createFragmentLista()
                return@OnNavigationItemSelectedListener true
            }
             id.nav_item -> {
                 createFragmentItens()
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        createFragmentLista()



        val transacoes = listOf(Transacao(BigDecimal("200.0"),categoria = "carnes"),
                Transacao(BigDecimal("100.0") ,categoria = "Legumes"))

       // lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
        nav_lista.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



    }

    fun createFragmentLista(){

        val transation = manager.beginTransaction()
        val fragment = ListaFragment()
        transation.replace(R.id.nav_lista,fragment)
        transation.addToBackStack(null)
        transation.commit()
    }

    fun  createFragmentItens(){
        val transation = manager.beginTransaction()
        val fragment = ListaFragment()
        transation.replace(R.id.nav_item,fragment)
        transation.addToBackStack(null)
        transation.commit()

    }

}
