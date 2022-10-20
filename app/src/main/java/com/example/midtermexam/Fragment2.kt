import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midtermexam.PREFERENCE_NAME
import com.example.midtermexam.USER_NAME
import com.example.midtermexam.databinding.Fragment2Binding


class Fragment2 : Fragment() {
    private lateinit var binding : Fragment2Binding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  Fragment2Binding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registeredUsername.text = String.format("USERNAME: %s",sharedPreferences.getString(USER_NAME,""))
    }
}