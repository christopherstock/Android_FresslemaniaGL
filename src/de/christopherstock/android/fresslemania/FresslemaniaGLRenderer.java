/*  $Id: Shooter.java 1176 2012-03-28 22:54:10Z jenetic.bytemare@gmail.com $
 *  =======================================================================================
 */
    package de.christopherstock.android.fresslemania;

    import  javax.microedition.khronos.egl.*;
    import  javax.microedition.khronos.opengles.*;
    import  android.opengl.*;

    /******************************************************************************************
    *   The project's activity class.
    *
    *   @version    0.1
    *   @author     Christopher Stock
    *******************************************************************************************/
    public class FresslemaniaGLRenderer implements GLSurfaceView.Renderer
    {
        @Override
        public void onSurfaceCreated( GL10 gl, EGLConfig config )
        {        // Do nothing special.
        }

        @Override
        public void onSurfaceChanged( GL10 gl, int w, int h )
        {
            gl.glViewport(0, 0, w, h);
        }

        @Override
        public void onDrawFrame( GL10 gl )
        {
            gl.glClearColor( 0.0f, 1.0f, 0.0f, 0.5f );
            gl.glClear( GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT );
        }
    }
