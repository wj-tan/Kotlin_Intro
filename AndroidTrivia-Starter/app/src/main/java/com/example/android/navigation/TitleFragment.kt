package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Binding object is similar to setContentView()
        // inflater is used to inflate the binding layout
        // XML layout to inflate for this case is fragment_title
        //
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,container,false)

        // Play button on the TitleFragment Play Button
        // action_titleFragment_to_gameFragment for this case is the id set in the navigation.xml
        binding.playButton.setOnClickListener{
            view : View -> view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }

        // Enables the Triple Dot option menu
        setHasOptionsMenu(true)
        return binding.root

    }
    
    // This method add the options menu and inflate the menu resource file
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
    }

    // Method for handling the appropriate action to take then the menu item is tapped
    // In this case is to navigate to the fragment that has the same id
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}