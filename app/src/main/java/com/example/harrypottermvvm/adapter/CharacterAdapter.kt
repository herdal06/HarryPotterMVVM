package com.example.harrypottermvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.harrypottermvvm.databinding.ItemCharacterRowBinding
import com.example.harrypottermvvm.fragments.HomeFragmentDirections
import com.example.harrypottermvvm.model.CharacterResponseItem

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(val binding: ItemCharacterRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<CharacterResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CharacterResponseItem,
            newItem: CharacterResponseItem
        ): Boolean {
            return oldItem.actor == newItem.actor
        }

        override fun areContentsTheSame(
            oldItem: CharacterResponseItem,
            newItem: CharacterResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var character: List<CharacterResponseItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentCharacter = character[position]

        holder.binding.apply {
            textViewCharacterName.text = currentCharacter.name
            textViewHouseName.text = currentCharacter.house
            imageView.load(currentCharacter.image) {
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener { mView ->
            val direction =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(currentCharacter)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        //return differ.currentList.size
        return character.size
    }
}