package net.lomeli.equivalency.ee3;

import cpw.mods.fml.common.Loader;

public class AddonEE3 
{
	public static boolean checkEE3()
	{
		if (Loader.isModLoaded("EE3"))
		{
			try
			{
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		else
		{
			System.out.println("EE3 not found. This mod will not do anything without Equivalent Exchanged 3 installed!");
			return false;
		}
	}

}
