package pt.ua.querodoar;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Donation_Institutions extends Fragment {
	
	private static final String ARG_SECTION_NUMBER = "section_number";

	
	List<ClassInstitution> institutions;
	Map<ClassInstitution,List<ClassProduct>> collectionMapInstProd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	public static Fragment_Donation_Institutions newInstance(int sectionNumber) {
		Fragment_Donation_Institutions fragment = new Fragment_Donation_Institutions();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_donation_institutions, container, false);

		return v;
	}

}
