package mobi.audiogear.staticfrequency.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import mobi.audiogear.staticfrequency.R;
import mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSPager;
import mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSKast;

/**
 * The custom Fragment for kast. This Fragment has a corresponding Element
 * {@link mobi.audiogear.staticfrequency.elements.SpringboardActivity.DSKast}.
 */
public class KastPage extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
    super.onCreateView(inflater, container, bundle);

    View view = inflater.inflate(R.layout.kast_page, container, false);

    return view;
  }
}