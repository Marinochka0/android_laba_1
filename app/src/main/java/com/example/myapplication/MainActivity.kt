package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<People>()
        for (i in 0..20) {
            list.add(People(
                name = People.set_name(),
                type = People.set_type(),
                cclass = People.set_text()
            ))
        }

        binding.recycler.layoutManager = GridLayoutManager(this, 2) // Установка GridLayoutManager с двумя колонками
        binding.recycler.adapter = PeopleListAdapter(list)
    }
}

class People(
    val name: String,
    val type: Int,
    val cclass: String
) {
    companion object {
        val name_list = listOf("Шут Марина Владимировна", "Ткаченко Полина Дмитриевна", "Сокиркина Диана Владимировна", "Иванова Иванка Ивановна")
        val cclass_list = listOf(
            "Прикладная математика и информатика",
            "Прикладная информатика",
            "Программная инженерия",
            "Информационная безопастность"
        )

        fun set_type(): Int {
            return Random.nextInt(0, 4)
        }

        fun set_name(): String {
            return name_list[Random.nextInt(0, name_list.size)]
        }

        fun set_text(): String {
            return cclass_list[Random.nextInt(0, cclass_list.size)]
        }
    }
}
