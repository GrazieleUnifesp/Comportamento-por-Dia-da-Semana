import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SeletorEstrategia {

    private final Map<String, EstrategiaDia> estrategias = new HashMap<>();
    private final EstrategiaDia semEstrategia = new SemEstrategia();

    public SeletorEstrategia() {
        estrategias.put("segunda", new SegundaEstrategia());
        estrategias.put("terça",   new TercaEstrategia());
        estrategias.put("quarta",  new QuartaEstrategia());
        estrategias.put("quinta",  new QuintaEstrategia());
        estrategias.put("sexta",   new SextaEstrategia());
        estrategias.put("sábado",  new SabadoEstrategia());
        estrategias.put("domingo", new DomingoEstrategia());
    }

    public EstrategiaDia obter(String dia) {
        return estrategias.getOrDefault(dia.toLowerCase().trim(), semEstrategia);
    }

    public String diaHoje() {
        return switch (LocalDate.now().getDayOfWeek()) {
            case MONDAY    -> "segunda";
            case TUESDAY   -> "terça";
            case WEDNESDAY -> "quarta";
            case THURSDAY  -> "quinta";
            case FRIDAY    -> "sexta";
            case SATURDAY  -> "sábado";
            case SUNDAY    -> "domingo";
        };
    }
}