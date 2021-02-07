package com.manohar.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ViewAnimal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_animal)

        var animalimage: ImageView =  findViewById(R.id.animalimage)
        var animalname: TextView =  findViewById(R.id.name)
        var animaldesc: TextView =  findViewById(R.id.desc)

        var bundle:Bundle = intent.extras!!
        animalimage.setImageResource(bundle.getString("image")!!.toInt())
        animalname.setText(bundle.getString("name"))
        animaldesc.setText(bundle.getString("desc"))

    }
}