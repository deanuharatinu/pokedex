//
//  HomeScreenViewModel.swift
//  iosApp
//
//  Created by Deanu Haratinu on 04/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Combine
import shared

@MainActor
class HomeScreenViewModel: ObservableObject {
  private var viewModel = KoinHelper().homeViewModel
  @Published public var pokemonList: [PokemonDetail] = []
  
  func getPokemonList() {
	viewModel.pokemonList.watch { pokemonFlow in
	  guard let list = pokemonFlow?.compactMap({$0 as? PokemonDetail}) else {
		return
	  }
	  
	  self.pokemonList = list
	}
  }
}
