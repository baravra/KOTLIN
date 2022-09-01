package com.example.prova2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class dadosActivity : AppCompatActivity() {
    lateinit var texto : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados)
        texto = findViewById(R.id.txtDados)
        jsonLoad()
    }
    fun jsonLoad(){
        val jsonData = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "json","raw",
                applicationContext.packageName
            )
        ).bufferedReader().use{ it.readText() } // leitura externa

        val outputString = JSONObject(jsonData)
        Log.d("Tag_Error", "Houve um erro " + outputString)
        val users = outputString.getJSONArray("Cars") as JSONArray
        for(i in 0 until users.length()){
            val id = users.getJSONObject(i).get("id")
            val nome = users.getJSONObject(i).get("name")
            val cpf = users.getJSONObject(i).get("value")

            val data = "\nId -> $id\nNome -> $nome\nValor -> $cpf"
            val previous = texto.text
            texto.text = previous.toString() + data


        }
    }
}