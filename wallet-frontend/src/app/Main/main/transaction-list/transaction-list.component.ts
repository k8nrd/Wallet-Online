import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../../../Services/transaction-service';
import { Transaction, IncomeCathegory } from '../../../Domains/app-interfaces';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  private transactions: Transaction[];
  private isError: boolean = false;
  constructor(private transactionService: TransactionService) { }

  ngOnInit() {
    this.transactionService.getTransactionList().subscribe(data => {
      this.transactions = data;
    },err => {
      this.isError = true;
      console.log(err);
    })
  }

}
