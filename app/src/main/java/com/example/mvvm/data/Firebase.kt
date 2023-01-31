package com.example.mvvm.data



import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class Firebase  {


    val db = FirebaseFirestore.getInstance()

    fun createNote(
        note: String,
        date: String,
        onSuccessListener: () -> Unit

        ){
        val data = hashMapOf(
            "note" to note.toString(),
           "date" to date.toString()
        )
        db.collection("Notes")
            .document(note)
            .set(data, SetOptions.merge())
            .addOnSuccessListener {
                onSuccessListener

            }
    }

    /*fun getNote(onSuccessBehaviour:(datos: MutableList<Notes>) -> Unit){

        val datos: MutableList<Notes> = mutableListOf()

        db.collection("Notes")
            .get().addOnSuccessListener { rs ->
                for (encontrado in rs) {
                    val lista = Notes(
                        encontrado["note"].toString(),
                        encontrado["date"].toString()
                    )
                        datos+= lista.toString()
                       if (datos.toString().isEmpty()){
                           datos = "No existen datos"

                    }
                }
            }
    }*/
}