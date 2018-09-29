import { Component, OnInit } from '@angular/core';
import { Transaction, Expense, ExpenseCathegory } from '../../../Domains/app-interfaces';
import { TransactionService } from '../../../Services/transaction-service';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit {
  private transaction: Expense[];
  id = 'chart1';
  width = 1000;
  height = 400;
  type = 'column2d';
  dataFormat = 'json';
  dataSource;

  constructor(private transactionService: TransactionService) {
  }

  ngOnInit() {
    this.transactionService.getTransactionList().subscribe(trans => {
      this.transaction = trans as Expense[];
      console.log(this.transaction);
      this.initChart();
    })

  }

  initChart() {
    let pClothes:number=0;
    let pFood:number=0;
    let pGoodies:number=0;
    let pUtils:number=0;
    this.transaction.sort()
    this.transaction.forEach(element => {
      if(element.cathegory.toString() == ExpenseCathegory[ExpenseCathegory.CLOTHES]) {
        pClothes=pClothes+element.price;
      }
      if(element.cathegory.toString() == ExpenseCathegory[ExpenseCathegory.FOOD]) {
        pFood=pFood+element.price;
      }
      if(element.cathegory.toString() == ExpenseCathegory[ExpenseCathegory.GOODIES]) {
        pGoodies=pGoodies+element.price;
      }
      if(element.cathegory.toString() == ExpenseCathegory[ExpenseCathegory.UTILS]) {
        pUtils=pUtils+element.price;
      }
    });
  
  this.dataSource = {
    "chart": {
        "caption": "Your Expenses",
        "subCaption": "by cathegory",
        "numberprefix": "€",
        "theme": "fint"
    },
    "data": [
        {
            "label": "Clothes",
            "value": pClothes
        },
        {
            "label": "Food",
            "value": pFood
        },
        {
            "label": "Goodies",
            "value": pGoodies
        },
        {
            "label": "Utils",
            "value": pUtils
        },
    ]
}
}
}
