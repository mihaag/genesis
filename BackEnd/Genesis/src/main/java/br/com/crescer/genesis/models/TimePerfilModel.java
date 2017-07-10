
package br.com.crescer.genesis.models;

import br.com.crescer.genesis.entidades.Timecwi;
import java.util.List;

/**
 *
 * @author mirela.adam
 */
public class TimePerfilModel {
    private Timecwi time;
    private List<String> fotosMembros;
    
    public TimePerfilModel(){}

    public Timecwi getTime() {
        return time;
    }

    public void setTime(Timecwi time) {
        this.time = time;
    }

    public List<String> getFotosMembros() {
        return fotosMembros;
    }

    public void setFotosMembros(List<String> fotosMembros) {
        this.fotosMembros = fotosMembros;
    }
    
    
}
