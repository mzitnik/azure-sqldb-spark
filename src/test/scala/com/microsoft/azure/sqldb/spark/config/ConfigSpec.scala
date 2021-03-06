/**
  * The MIT License (MIT)
  * Copyright (c) 2018 Microsoft Corporation
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
package com.microsoft.azure.sqldb.spark.config

import com.microsoft.azure.sqldb.spark.SqlDBSpark

class ConfigSpec extends SqlDBSpark {

  it should "throw IllegalArgumentException if required properties aren't met" in {
    an [IllegalArgumentException] should be thrownBy {
      Config(Map("url" -> "mysql.database.windows.net"))
    }
  }

  it should "throw IllegalArgumentException if queryCustom and dbTable are both stated" in {
    an [IllegalArgumentException] should be thrownBy {
      Config(Map(
        "url"          -> "mysql.database.windows.net",
        "databaseName" -> "MyDatabase",
        "user"         -> "MyUsername",
        "password"     -> "**********",
        "dbTable"      -> "MyDBTable",
        "QueryCustom"  -> "MyQueryCustom"
      ))
    }
  }
}
