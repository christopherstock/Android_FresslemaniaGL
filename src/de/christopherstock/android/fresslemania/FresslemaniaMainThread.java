/*  $Id: Shooter.java 1176 2012-03-28 22:54:10Z jenetic.bytemare@gmail.com $
 *  =======================================================================================
 */
    package de.christopherstock.android.fresslemania;

    import  de.christopherstock.android.lib.*;

    /******************************************************************************************
    *   The project's activity class.
    *
    *   @version    0.1
    *   @author     Christopher Stock
    *******************************************************************************************/
    public class FresslemaniaMainThread extends Thread
    {
        @Override
        public void run()
        {
            while ( !FresslemaniaActivity.destroyed )
            {
                //Log.i( "info", "run" );

                //check keys

                //calculate
                FresslemaniaCanvas.a++;

                //draw
                FresslemaniaCanvas.draw();

                //delay
                Lib.delay( 250 );
            }
        }
    }
