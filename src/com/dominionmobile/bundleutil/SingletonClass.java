/*
 * :folding=explicit:collapseFolds=1:
 */

/**
 *	  Bundle_Util is a utility for bundletool
 *
 *	  Copyright (c) 2022 Joseph Siebenmann
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General  Public License as published by
 *    the Free Software Foundation; version 2.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see<http://www.gnu.org/licenses/>.
 */

package com.dominionmobile.bundleutil;

public class SingletonClass
{
    private static SingletonClass single_instance = null;
    
    public String sBundlePath;
    public boolean bConnected;
    //public boolean bReleaseSelected;
    
    private SingletonClass()
    {
    }
    
    public static SingletonClass getInstance()
    {
        if ( single_instance == null )
            single_instance = new SingletonClass();
        
        return single_instance;
    }
}


