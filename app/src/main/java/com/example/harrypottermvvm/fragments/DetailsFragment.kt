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
            textViewNameDetails.text = character.name
            textViewHouseDetails.text = character.house
            textViewActor.text = character.actor
            textViewGender.text = character.gender
            textViewYearOfBirth.text = character.yearOfBirth
            textViewHairColor.text = character.hairColor
            textViewEyeColor.text = character.eyeColor
            textViewIsWizard.text = character.wizard.toString()
            textViewIsAlive.text = character.alive.toString()
            imageViewDetails.load(character.image) {
                crossfade(true)
                crossfade(1000)
            }
            buttonGoToReference.setOnClickListener { mView ->
                val direction =
                    DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(character)
                mView.findNavController().navigate(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}