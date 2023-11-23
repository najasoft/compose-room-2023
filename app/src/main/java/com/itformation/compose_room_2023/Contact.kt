package com.itformation.compose_room_2023

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (@PrimaryKey(autoGenerate = true) var idContact: Long=0,
                    val nomContact :String)