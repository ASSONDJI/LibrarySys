package INAF.LybraSys.Ressource.Api.Dto;

public record RessourceResponseDto(
        Integer idRessource,
        String titre,
        String auteur,
        String type
) {
}
