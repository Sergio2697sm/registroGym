package com.example.registrogym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth



class registry_activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)
        //auth = Firebase.auth


        var registro: Button = findViewById(R.id.btnRegistro)
        var email: EditText = findViewById(R.id.etCorreo)
        var password: EditText = findViewById(R.id.etPass)
        var repPassword: EditText = findViewById(R.id.etRepPass)

      registro.setOnClickListener {
          if (email.text.isNotEmpty() || password.text.isNotEmpty()) {
            if(password.text.toString().equals(repPassword.text.toString())){
                if (password.length() >= 6) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        email.text.toString(),
                        password.text.toString()
                    )
                        .addOnCompleteListener {
                            if (it.isComplete) {
                                Toast.makeText(this, "Creado", Toast.LENGTH_LONG).show()
                                startActivity(Intent(this, LoginActivity::class.java))
                            } else {
                                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                            }
                        }
                }else {
                    Toast.makeText(this, "Las contraseñas tienen que tener un minimo de 6 caracteres", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Las contraseñas tienen que ser iguales", Toast.LENGTH_LONG).show()
            }
          }else {
              Toast.makeText(this, "Rellena el correo y la contraseña", Toast.LENGTH_LONG).show()
          }
      }

    }
}