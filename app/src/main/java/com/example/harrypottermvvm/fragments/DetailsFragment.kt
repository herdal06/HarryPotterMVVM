package com.example.harrypottermvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.harrypottermvvm.R
import com.example.harrypottermvvm.databinding.FragmentDetailsBinding
import com.example.harrypottermvvm.model.CharacterResponseItem


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var character: CharacterResponseItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        character = args.character

        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            textViewNameDetails.text = "Character name : " + character.name
            textViewHouseDetails.text = "House : " + character.house
            textViewActor.text = "Actor's name : " + character.actor
            textViewGender.text = "Gender : " + character.gender
            textViewYearOfBirth.text = "Year of birth : " + character.yearOfBirth
            textViewHairColor.text = "Hair color : " + character.hairColor
            textViewEyeColor.text = "Eye color : " + character.eyeColor
            textViewIsWizard.text = "Is he/she a wizard ? : " + character.wizard.toString()
            textViewIsAlive.text = "Is he/she alive? : " + character.alive.toString()
            imageViewDetails.load(character.image) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}