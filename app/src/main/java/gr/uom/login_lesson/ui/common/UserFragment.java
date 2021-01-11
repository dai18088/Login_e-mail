package gr.uom.login_lesson.ui.common;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import gr.uom.login_lesson.R;
import gr.uom.login_lesson.ui.login.LoginActivity;


public class UserFragment extends Fragment {

    private FirebaseAuth firebaseAuth;

    public UserFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        firebaseAuth=FirebaseAuth.getInstance();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu,menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutmenuitem:
            doLogout();
            return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    private void doLogout() {
        Log.d("Marios","logging out");
        firebaseAuth.signOut();
        Intent intent=new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_blank, container, false);
    }
}