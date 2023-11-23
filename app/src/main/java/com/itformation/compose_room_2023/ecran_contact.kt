@file:OptIn(ExperimentalMaterial3Api::class)

package com.itformation.compose_room_2023


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun EcranContact(){
    val vm:ContactViewModel = ContactViewModel()
    val listeContact = vm.getContact().collectAsState(initial = emptyList()).value
    val txtIdContact= remember { mutableStateOf(0L) }
    val txtNomContact= remember { mutableStateOf("") }
    val selectedContact= remember { mutableStateOf(-1L) }

    LazyColumn{
        item{
            Column{
                Row {
                    TextField(value = txtIdContact.value.toString(), onValueChange = {
                        txtIdContact.value=it.toLong()
                    }, label = { Text("Id Contact") }, modifier = Modifier.weight(0.20f))
                    TextField(value = txtNomContact.value, onValueChange = {
                        txtNomContact.value=it
                    }, label = { Text("Nom Contact") })
                    Button(onClick = { vm.addContact(Contact(nomContact = txtNomContact.value)) }) {
                        Icon(Icons.Filled.Person, contentDescription = "Ajouter",
                            modifier = Modifier.weight(0.15f))
                    }
                }
                Row{
                    val nb=listeContact.size?:0
                    Text("Liste des contacts:$nb" , style = MaterialTheme.typography.bodyLarge)
                } }
        }
        items(listeContact){Row (
            modifier = Modifier.selectable(
                selected = selectedContact.value == it.idContact,
                onClick = {
                    selectedContact.value = it.idContact
                txtNomContact.value=it.nomContact
                txtIdContact.value=it.idContact}
            ).fillMaxSize()
            )
        {
            Text(
                text = it.idContact.toString(), style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(0.15f)
            )
            Text(
                text = it.nomContact, style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.7f)
            )
            Button(onClick = { vm.delContact(it) } , modifier = Modifier.weight(0.15f)     ) {
                Icon(Icons.Filled.Delete, contentDescription = "Supprimer",
                    )
            } } } } }


@Preview(showBackground = true)
@Composable
fun pre(){
    EcranContact()
}
