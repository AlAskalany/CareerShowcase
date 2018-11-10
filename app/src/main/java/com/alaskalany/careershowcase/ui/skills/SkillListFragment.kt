/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase.ui.skills

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alaskalany.careershowcase.R
import com.alaskalany.careershowcase.databinding.FragmentSkillListBinding
import com.alaskalany.careershowcase.entity.SkillEntity
import com.alaskalany.careershowcase.model.Skill
import com.alaskalany.careershowcase.ui.ScrollToTop
import com.alaskalany.careershowcase.viewmodel.SkillListViewModel

/**
 * A fragment representing a list of Items.
 *
 *
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class SkillListFragment : Fragment(), ScrollToTop {

    /**
     *
     */
    private val skillOnClickCallback = SkillOnClickCallback {
        Toast.makeText(this@SkillListFragment.context, "Clicked on SkillEntity Item", Toast.LENGTH_SHORT)
                .show()
    }

    /**
     *
     */
    private var mBinding: FragmentSkillListBinding? = null

    /**
     *
     */
    /**
     * @return
     */
    /**
     * @param adapter
     */
    protected var adapter: SkillAdapter? = null

    /**
     *
     */
    /**
     * @return
     */
    /**
     * @param mColumnCount
     */
    protected var columnCount = 1

    /**
     * @param context
     */
    override fun onAttach(context: Context?) {

        super.onAttach(context)
    }

    /**
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (arguments != null) {
            columnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
        }
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_skill_list, container, false)
        adapter = SkillAdapter(skillOnClickCallback)
        val context = mBinding!!.root
                .context
        if (columnCount <= 1) {
            mBinding!!.listSkill.layoutManager = LinearLayoutManager(context)
        } else {
            mBinding!!.listSkill.layoutManager = GridLayoutManager(context, columnCount)
        }
        val decor = DividerItemDecoration(activity!!.applicationContext, DividerItemDecoration.HORIZONTAL)
        mBinding!!.listSkill.addItemDecoration(decor)
        mBinding!!.listSkill.adapter = adapter

        return mBinding!!.root
    }

    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * [.setRetainInstance] to retain their instance,
     * as this skillOnClickCallback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after [.onCreateView]
     * and before [.onViewStateRestored].
     *
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        val _model = ViewModelProviders.of(this)
                .get(SkillListViewModel::class.java)
        mBinding!!.skillListViewModel = _model
        _model.skills
                .observe(this, Observer { pWorkEntities ->
                    if (pWorkEntities != null) {
                        adapter!!.setSkillList(pWorkEntities)
                    } else {
                    }
                    mBinding!!.executePendingBindings()
                })
    }

    /**
     *
     */
    override fun onDetach() {

        super.onDetach()
    }

    override fun top() {

        mBinding!!.listSkill.smoothScrollToPosition(0)
    }

    companion object {

        /**
         *
         */
        protected val ARG_COLUMN_COUNT = "column-count"

        /**
         * @param columnCount
         *
         * @return
         */
        fun newInstance(columnCount: Int): SkillListFragment {

            val fragment = SkillListFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }
}
