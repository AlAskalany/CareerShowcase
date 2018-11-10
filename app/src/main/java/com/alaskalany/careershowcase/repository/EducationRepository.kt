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

package com.alaskalany.careershowcase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.alaskalany.careershowcase.entity.EducationEntity

class EducationRepository(private val dataRepository: DataRepository) {

    var observableEducations: MediatorLiveData<List<EducationEntity>>? = null

    fun insertAll(educationEntities: List<EducationEntity>) {

    }

    fun load(educationId: Int): LiveData<EducationEntity> {

        return dataRepository.database
                .educationDao()
                .load(educationId)
    }

    fun loadSync(educationId: Int): EducationEntity {

        return dataRepository.database
                .educationDao()
                .loadSync(educationId)
    }

    fun loadAll(): LiveData<List<EducationEntity>> {

        return dataRepository.database
                .educationDao()
                .loadAll()
    }

    fun getEducations(): MediatorLiveData<List<EducationEntity>>? {

        return observableEducations
    }
}