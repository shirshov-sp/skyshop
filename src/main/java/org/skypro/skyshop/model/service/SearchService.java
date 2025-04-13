package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<SearchResult> search(String searchText) {
        final String searchTerm = searchText.toLowerCase();
        return storageService.createSearchableCollection().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(searchTerm))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
