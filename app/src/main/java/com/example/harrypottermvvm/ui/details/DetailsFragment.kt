package com.example.harrypottermvvm.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.harrypottermvvm.R
import com.example.harrypottermvvm.databinding.FragmentDetailsBinding
import com.example.harrypottermvvm.model.CharacterResponseItem
import com.example.harrypottermvvm.utils.loadImage
import com.example.harrypottermvvm.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)


    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var character: CharacterResponseItem


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        character = args.character

        populateUI()
    }

    private fun populateUI() = with(binding) {
        binding.apply {
            (getString(R.string.character_name) + character.name).also {
                textViewNameDetails.text = it
            }
            (getString(R.string.house_name) + character.house).also {
                textViewHouseDetails.text = it
            }
            (getString(R.string.actor_name) + character.actor).also { textViewActor.text = it }
            (getString(R.string.gender) + character.gender).also { textViewGender.text = it }
            (getString(R.string.yearOfBirth) + character.yearOfBirth).also {
                textViewYearOfBirth.text = it
            }
            (getString(R.string.hairColor) + character.hairColor).also {
                textViewHairColor.text = it
            }
            (getString(R.string.eyeColor) + character.eyeColor).also { textViewEyeColor.text = it }
            (getString(R.string.isWizard) + character.wizard.toString()).also {
                textViewIsWizard.text = it
            }
            (getString(R.string.isAlive) + character.alive.toString()).also {
                textViewIsAlive.text = it
            }
            imageViewDetails.loadImage(character.image)
        }
    }
}