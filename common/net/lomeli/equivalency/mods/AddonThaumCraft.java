package net.lomeli.equivalency.mods;

import cpw.mods.fml.common.Loader;

public class AddonThaumCraft 
{
	public static boolean checkThaumCraft()
    {
        if (Loader.isModLoaded("Thaumcraft"))
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
			System.out.println("Thaumcraft 3 not found, ignoring");
			return false;
		}
    }

}
