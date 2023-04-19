//
//  HomeScreen.swift
//  iosApp
//
//  Created by Deanu Haratinu on 04/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeScreen: View {
  @StateObject private var viewModel = HomeScreenViewModel()
  
  var body: some View {
	Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
	  .onAppear {
		viewModel.getPokemonList()
		
	  }
  }
}

struct HomeScreen_Previews: PreviewProvider {
  static var previews: some View {
	HomeScreen()
  }
}
