import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../../../Services/transaction-service';
import { Transaction, IncomeCathegory, Income } from '../../../Domains/app-interfaces';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  private transactions: Transaction[];
  private isError: boolean = false;
  private isLoading: boolean = true;
  private curretViewTransactions: Transaction[];
  private filteredTransactions: Transaction[];
  private page:number;
  private pagesNumber:number;
  constructor(private transactionService: TransactionService) { }

  ngOnInit() {
    this.transactionService.getTransactionList().subscribe(data => {
      this.transactions = data;
      this.isLoading = false;
      this.filteredTransactions = this.transactions;
      this.curretViewTransactions = this.filteredTransactions.slice(0,5);
      this.page = 1;
      this.pagesNumber = (this.filteredTransactions.length / 5)*10;
    },err => {
      this.isError = true;
      console.log(err);
    })
  }

  onFilterChoose(id) {
    this.filteredTransactions = new Array();
    if(id == 1){
      this.filteredTransactions = this.transactions;
    }
    if(id == 2){
      this.transactions.forEach(tran => {
        if(tran.flag){
          this.filteredTransactions.push(tran);
        }
      })
    }
    if(id == 3){
      this.transactions.forEach(tran => {
        if(!tran.flag){
          this.filteredTransactions.push(tran);
        }
      })
    }
    this.onPageChange(this.page);
  }

  onSortChoose() {

  }

  onPageChange(newPage) {
    this.pagesNumber = (this.filteredTransactions.length / 5)*10;
    this.curretViewTransactions = this.filteredTransactions.slice((newPage-1)*5,((newPage-1)*5)+5);
  }

  

}
