package com.example.prova2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogar = findViewById<Button>(R.id.btnLogar)

        var login = findViewById<EditText>(R.id.edtLogin)
        var senha = findViewById<EditText>(R.id.edtSenha)

        btnLogar.setOnClickListener {
            if (login.text.toString() == "ALUNO" && senha.text.toString() == "123456"){
                val i = Intent(this, dadosActivity::class.java )
                startActivity(i)
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alerta")
                builder.setMessage("Login incorredo!")
                builder.setNeutralButton("OK"){dialog, which ->
                    Toast.makeText(this,"Insira novos dados", Toast.LENGTH_SHORT).show()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }


}