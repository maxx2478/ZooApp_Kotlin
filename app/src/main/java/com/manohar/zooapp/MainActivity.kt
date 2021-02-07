package com.manohar.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    var listview = ArrayList<AnimalPojo>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview.add(AnimalPojo(R.drawable.giraffe, "Giraffe", "Tall Animals"))
        listview.add(AnimalPojo(R.drawable.babyelephant, "Baby Elephant", "Cute Animals"))
        listview.add(AnimalPojo(R.drawable.cat45760_960_720, "Cat", "Common Pets"))
        listview.add(AnimalPojo(R.drawable.hummingbird, "Humming Bird", "Faster & Powerful"))
        listview.add(AnimalPojo(R.drawable.stegosauru, "Stegosauru", "Just Kidding, they doesn't exists now"))
        listview.add(AnimalPojo(R.drawable.cat45760_960_720, "Cat", "Common Pets"))
        listview.add(AnimalPojo(R.drawable.stegosauru, "Stegosauru", "Just Kidding, they doesn't exists now"))


        adapter = AnimalsAdapter(listview, applicationContext)
        var listviewx:ListView = findViewById(R.id.listview)
        listviewx.adapter = adapter

    }


    class AnimalsAdapter: BaseAdapter {
        var animallist = ArrayList<AnimalPojo>()
        var context:Context?=null
        constructor(animallist:ArrayList<AnimalPojo>, context:Context):super()
        {
          this.animallist = animallist
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var animals = animallist.get(position)
            var inflater:LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view:View = inflater.inflate(R.layout.animal_layout, null)

            var animalimage:ImageView =  view.findViewById(R.id.animalimage)
            var animalname:TextView =  view.findViewById(R.id.name)
            var animaldesc:TextView =  view.findViewById(R.id.desc)

            animalimage.setImageResource(animals.image!!)
            animalname.setText(animals.name)
            animaldesc.setText(animals.desc)

            view.setOnClickListener(View.OnClickListener {

                val intent = Intent(context, ViewAnimal::class.java)
                intent.putExtra("image", animals.image.toString())
                intent.putExtra("name", animals.name.toString())
                intent.putExtra("desc", animals.desc.toString())
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(intent)

            })

            return view


        }

        override fun getItem(position: Int): Any {
            return animallist.get(position)
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getCount(): Int {
            return animallist.size
        }
    }

}