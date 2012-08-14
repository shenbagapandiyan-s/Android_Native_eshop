/*
 * ###
 * PHR_AndroidNative
 * %%
 * Copyright (C) 1999 - 2012 Photon Infotech Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ###
 */
/*
 * Classname: CategoryListViewCustomAdapter
 * Version information: 1.0
 * Date: Nov 24, 2011
 * Copyright notice:
 */
package com.photon.phresco.nativeapp.eshop.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.photon.phresco.nativeapp.R;
import com.photon.phresco.nativeapp.eshop.core.Constants;
import com.photon.phresco.nativeapp.eshop.core.ImageCacheManager;
import com.photon.phresco.nativeapp.eshop.logger.PhrescoLogger;
import com.photon.phresco.nativeapp.eshop.model.category.Category;

/**
 * Custom adapter class extending the BaseAdapter for Category listing
 *
 * @author viral_b
 *
 */
public class CategoryListViewCustomAdapter extends BaseAdapter {
	private static final String TAG = "CategoryListViewCustomAdapter ***** ";
	private List<Category> categoryList;
	private LayoutInflater inflater;

	public CategoryListViewCustomAdapter(Activity context, List<Category> categoryList) {
		super();
		this.categoryList = categoryList;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return categoryList.size();
	}

	@Override
	public Object getItem(int position) {
		return categoryList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return categoryList.get(position).getId();
	}

	/**
	 * Static class to hold the category listview single item
	 *
	 * @author viral_b
	 *
	 */
	public class ViewHolder {
		private ImageView imgCategoryImage;
		private TextView txtCategoryName;
		private TextView txtCategoryItemCounter;
		private ImageView imgArrow;

		protected ViewHolder() {
		}
	}

	@Override
	public View getView(int position, View cView, ViewGroup parent) {

		ViewHolder holder;
		View convertView = cView;
		try {
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.category_listview_item, null);

				holder.imgCategoryImage = (ImageView) convertView.findViewById(R.id.img_category_image);
				holder.txtCategoryName = (TextView) convertView.findViewById(R.id.category_title);
				holder.txtCategoryItemCounter = (TextView) convertView.findViewById(R.id.category_list_counter);
				holder.imgArrow = (ImageView) convertView.findViewById(R.id.arrow_icon);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Category item = (Category) categoryList.get(position);
			ImageCacheManager imgCacheManager = new ImageCacheManager();
			imgCacheManager.renderImage(holder.imgCategoryImage, Constants.CATEGORIES_FOLDER_PATH + item.getImage().substring(item.getImage().lastIndexOf("/") + 1));
			holder.txtCategoryName.setText(item.getName());
			holder.txtCategoryItemCounter.setText(String.valueOf(item.getProductCount()));
			holder.imgArrow.setBackgroundResource(R.drawable.arrow_icon);
		} catch (Exception ex) {
			PhrescoLogger.info(TAG + " - getView  - Exception : " + ex.toString());
			PhrescoLogger.warning(ex);
		}
		return convertView;
	}
}
