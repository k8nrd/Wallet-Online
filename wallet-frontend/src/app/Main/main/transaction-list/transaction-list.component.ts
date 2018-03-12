import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { TransactionService } from '../../../Services/transaction-service';
import { Transaction, IncomeCathegory, Income, Expense } from '../../../Domains/app-interfaces';

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
  private expensesSum;
  private incomesSum;
  private balance;
  constructor(private transactionService: TransactionService, private cdRef : ChangeDetectorRef) { }

  ngOnInit() {
    this.balance = 0;
    this.transactionService.getTransactionList().subscribe(data => {
      this.transactions = data;
      this.isLoading = false;
      this.filteredTransactions = this.transactions;
      this.curretViewTransactions = this.filteredTransactions.slice(0,5);
      this.page = 1;
      this.pagesNumber = (this.filteredTransactions.length / 5)*10;
      this.balanceCount();
    },err => {
      this.isError = true;
      console.log(err);
    })
  }

  balanceCount() {
    let incomes =0;
    let expenseSum =0;

    this.transactions.forEach(tran => {
      if(tran.flag){
        incomes+=tran.price;
      }else{
        expenseSum+=tran.price;
      }
    });
    this.incomesSum = incomes;
    this.expensesSum = expenseSum;
    this.balance = incomes - expenseSum;
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

  onDelete(id:number) {
    this.transactionService.delete(id).subscribe(date => {
      this.cdRef.detectChanges();
      this.ngOnInit();
    })
  
  }

  repeatTransaction(trans) {
    if(trans.flag){
      this.transactionService.addIncome(trans as Income).subscribe(date => {
        this.ngOnInit();
      });
    }else {
      this.transactionService.addExpense(trans as Expense).subscribe(date => {
        this.ngOnInit();
      });
    }
  }

  

}
