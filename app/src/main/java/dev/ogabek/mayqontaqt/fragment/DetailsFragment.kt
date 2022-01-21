package dev.ogabek.mayqontaqt.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import dev.ogabek.mayqontaqt.R
import dev.ogabek.mayqontaqt.model.Contact

class DetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun newInstance(contact: Contact): DetailsFragment {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putParcelable("contact", contact)
        detailsFragment.arguments = bundle
        return detailsFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = arguments?.getParcelable<Contact>("contact")

        val name: TextView = view.findViewById(R.id.tv_contact_full_name)
        val number: TextView = view.findViewById(R.id.tv_contact_username)
        val back: Button = view.findViewById(R.id.btn_back_contact)

        back.setOnClickListener {
            activity?.onBackPressed()
        }

        name.text = contact!!.name
        number.text = contact.phoneNumber

    }
}