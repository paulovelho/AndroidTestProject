package ottvlc;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;


public class ottvlc {

    public ottvlc(){
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }


}
