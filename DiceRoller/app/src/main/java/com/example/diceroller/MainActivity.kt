package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()
            val diceImage: ImageView = findViewById(R.id.imageView)
            when (rollDice()) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                else -> diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    }

    private fun rollDice(): Any {
        val dice = Dice(6)
        return dice.roll()
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}