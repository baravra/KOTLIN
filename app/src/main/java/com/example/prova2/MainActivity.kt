package com.example.prova2


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nome = findViewById<EditText>(R.id.edtNome)
        var telefone = findViewById<EditText>(R.id.edtTelefone)
        var email = findViewById<EditText>(R.id.edtEmail)

        var txtNome = findViewById<TextView>(R.id.txtNome)
        var txtTelefone = findViewById<TextView>(R.id.txtTelefone)
        var txtEmail = findViewById<TextView>(R.id.txtEmail)

        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var btnLoad =  findViewById<Button>(R.id.btnLoad)
        var btnProxima =  findViewById<Button>(R.id.btnProxima)

        var shared = getSharedPreferences("FileKey", Context.MODE_PRIVATE)

        btnAdd.setOnClickListener {
            val editar = shared.edit()
            editar.apply{
                putString("NOME", nome.text.toString() )
                putString("TELEFONE", telefone.text.toString() )
                putString("EMAIL", email.text.toString() )
                apply()
            }
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alerta")
            builder.setMessage("Adicionado!")
            builder.setNeutralButton("OK"){dialog, which ->
                Toast.makeText(this,"Dados inseridos", Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        btnLoad.setOnClickListener {
            var nomeShared = shared.getString("NOME", null)
            var telefoneShared = shared.getString("TELEFONE", null)
            var emailShared = shared.getString("EMAIL", null)

            txtNome.setText(nomeShared)
            txtTelefone.setText(telefoneShared)
            txtEmail.setText(emailShared)
        }

        btnProxima.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

    }

}