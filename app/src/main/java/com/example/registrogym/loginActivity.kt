package com.example.registrogym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        var botonRegistro: Button = findViewById(R.id.btCrear)

        //Boton Acceder
        val email: EditText = findViewById(R.id.etEmail)
        val password: EditText = findViewById(R.id.etPassword)
        val btonAcceder: Button = findViewById(R.id.btAcceder)

        btonAcceder.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    email.text.toString(),
                    password.text.toString()
                )
                    .addOnCompleteListener{
                        if (it.isComplete) {
                            Toast.makeText(this, "Entrado con exito", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this, MainActivity::class.java))
                        } else {
                            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                        }
                    }
            }else {
                Toast.makeText(this, "Autenticacion fallida", Toast.LENGTH_LONG).show()
            }
        }




        //Boton registrarse
        botonRegistro.setOnClickListener {
            var pasarActivity = Intent(this, registry_activity::class.java)
            startActivity(pasarActivity)
        }



    }
}
