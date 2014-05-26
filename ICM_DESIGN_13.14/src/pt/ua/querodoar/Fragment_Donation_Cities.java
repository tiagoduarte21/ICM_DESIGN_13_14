package pt.ua.querodoar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_Donation_Cities extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";

	List<ClassCity> cities;
	List<ClassInstitution> inst;
	Map<ClassCity, List<ClassInstitution>> collectionMapCityInst;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		createCityGroupList();

		createInstGroupList();

		createCityInstCollection();

	}

	private void createCityGroupList() {
		cities = new ArrayList<ClassCity>();
		cities.add(new ClassCity("Aveiro", 1000));
		cities.add(new ClassCity("Porto", 2000));
		cities.add(new ClassCity("Coimbra", 1000));
		cities.add(new ClassCity("Braga", 1100));

	}

	private void createInstGroupList() {
		inst = new ArrayList<ClassInstitution>();
		inst.add(new ClassInstitution("Institui��o 1", 0, "Aveiro", 1000,
				"Descri��o 1"));
		inst.add(new ClassInstitution("Institui��o 2", 0, "Porto", 1000,
				"Descri��o 2"));
		inst.add(new ClassInstitution("Institui��o 3", 0, "Coimbra", 1000,
				"Descri��o 3"));
		inst.add(new ClassInstitution("Institui��o 4", 0, "Braga", 1000,
				"Descri��o 4"));

	}

	private void createCityInstCollection() {

		collectionMapCityInst = new LinkedHashMap<ClassCity, List<ClassInstitution>>();

		for (ClassCity city : cities) {
			List<ClassInstitution> childList = new ArrayList<ClassInstitution>();

			for (ClassInstitution in : inst) {

				if (city.getName().equals(in.getLocation())) {

					childList.add(in);

				}

			}
			collectionMapCityInst.put(city, childList);
		}
	}

	public static Fragment_Donation_Cities newInstance(int sectionNumber) {
		Fragment_Donation_Cities fragment = new Fragment_Donation_Cities();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_donation_cities, container,
				false);

		ExpandableListView expListView = (ExpandableListView) v
				.findViewById(R.id.elvInstitutionList);
		final ExpandableCitiesListAdapter expListAdapter = new ExpandableCitiesListAdapter(
				getActivity(), cities, collectionMapCityInst);
		expListView.setAdapter(expListAdapter);

		return v;
	}

	public class ExpandableCitiesListAdapter extends BaseExpandableListAdapter {

		private Activity context;
		private Map<ClassCity, List<ClassInstitution>> miscCollections;
		private List<ClassCity> topiclist;

		public ExpandableCitiesListAdapter(Activity context,
				List<ClassCity> topiclist,
				Map<ClassCity, List<ClassInstitution>> miscCollections) {
			this.context = context;
			this.miscCollections = miscCollections;
			this.topiclist = topiclist;
		}

		public Object getChild(int groupPosition, int childPosition) {
			return miscCollections.get(topiclist.get(groupPosition)).get(
					childPosition);
		}

		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		public View getChildView(final int groupPosition,
				final int childPosition, boolean isLastChild, View convertView,
				ViewGroup parent) {
			final ClassInstitution topic = (ClassInstitution) getChild(
					groupPosition, childPosition);
			LayoutInflater inflater = context.getLayoutInflater();

			if (convertView == null) {
				convertView = inflater.inflate(
						R.layout.expandable_cities_view_child, null);
			}

			TextView viewExpCityInstName = (TextView) convertView
					.findViewById(R.id.viewExpCityInstName);
			TextView viewExpCityInstDescr = (TextView) convertView
					.findViewById(R.id.viewExpCityInstDescr);
			ImageView viewExpCityInstImage = (ImageView) convertView
					.findViewById(R.id.viewExpCityInstImage);

			viewExpCityInstName.setText(topic.getName());
			viewExpCityInstDescr.setText(topic.getDescription());
			viewExpCityInstImage.setImageResource(topic.getImage());

			// delete.setOnClickListener(new OnClickListener() {
			//
			// public void onClick(View v) {
			// AlertDialog.Builder builder = new AlertDialog.Builder(
			// context);
			// builder.setMessage("Do you want to remove?");
			// builder.setCancelable(false);
			// builder.setPositiveButton("Yes",
			// new DialogInterface.OnClickListener() {
			// public void onClick(DialogInterface dialog,
			// int id) {
			// List<String> child = miscCollections
			// .get(topiclist.get(groupPosition));
			// child.remove(childPosition);
			// notifyDataSetChanged();
			// }
			// });
			// builder.setNegativeButton("No",
			// new DialogInterface.OnClickListener() {
			// public void onClick(DialogInterface dialog,
			// int id) {
			// dialog.cancel();
			// }
			// });
			// AlertDialog alertDialog = builder.create();
			// alertDialog.show();
			// }
			// });

			return convertView;
		}

		public int getChildrenCount(int groupPosition) {
			return miscCollections.get(topiclist.get(groupPosition)).size();
		}

		public Object getGroup(int groupPosition) {
			return topiclist.get(groupPosition);
		}

		public int getGroupCount() {
			return topiclist.size();
		}

		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			ClassCity city = (ClassCity) getGroup(groupPosition);
			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(
						R.layout.expandable_cities_view_parent, null);
			}

			TextView viewExpCityName = (TextView) convertView
					.findViewById(R.id.viewExpCityName);
			TextView viewExpCityDescr = (TextView) convertView
					.findViewById(R.id.viewExpCityDescr);
			ImageView viewExpCityImage = (ImageView) convertView
					.findViewById(R.id.viewExpCityImage);

			viewExpCityName.setText(city.getName());
			viewExpCityName.setTypeface(null, Typeface.BOLD);
			// viewExpCityDescr.setText(city.getPoints());
			// viewExpCityImage.setImageResource(city.getImage());

			return convertView;
		}

		public boolean hasStableIds() {
			return true;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

	}

}
